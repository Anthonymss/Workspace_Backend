package com.coworking.auth_service.service.impl;

import com.coworking.auth_service.configuration.jwt.JwtTokenProvider;
import com.coworking.auth_service.exception.DuplicateEmailException;
import com.coworking.auth_service.exception.InvalidTokenOfGoogleException;
import com.coworking.auth_service.exception.UserNotFoundException;
import com.coworking.auth_service.exception.UserNotAuthorization;
import com.coworking.auth_service.persistence.entity.Role;
import com.coworking.auth_service.persistence.entity.User;
import com.coworking.auth_service.persistence.entity.UserAuthentication;
import com.coworking.auth_service.persistence.repository.RoleRepository;
import com.coworking.auth_service.persistence.repository.UserAuthenticationRepository;
import com.coworking.auth_service.persistence.repository.UserRepository;
import com.coworking.auth_service.presentation.dto.AuthRequest;
import com.coworking.auth_service.presentation.dto.UserDto;
import com.coworking.auth_service.util.enums.RoleName;
import com.coworking.auth_service.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;//pone el constructor para la inyeccion de dependecias :v

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserAuthenticationRepository authenticationRepository;
    private final String clientIdGoogle;

    @Override
    @Transactional
    public Map<String,String> generateTokenRegisterForGoogle(String idTokenString) {
        GoogleIdToken.Payload payload = verifyAndGetPayload(idTokenString);
        String email = payload.getEmail();
        String firstName = (String) payload.get("given_name");
        String lastName = (String) payload.get("family_name");
        String profileImageUrl = (String) payload.get("picture");
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new DuplicateEmailException(email);
        } else {
            User newUser = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .profileImageUrl(profileImageUrl)
                    .roles(Set.of(roleRepository.findByName(RoleName.USER)))
                    .build();
            UserAuthentication userAuthentication = UserAuthentication.builder()
                    .providerId(payload.getSubject())
                    .user(newUser)
                    .authProvider("google")
                    .build();
            userRepository.save(newUser);
            authenticationRepository.save(userAuthentication);
            User userResponse=userRepository.findByEmail(email).get();
            String TOKEN=jwtTokenProvider.generateToken(newUser);
            return buildResponseMap(userResponse,TOKEN);
        }
    }

    @Override
    @Transactional
    public Map<String,String> generateTokenLoginForGoogle(String tokenGoogle) {
        GoogleIdToken.Payload payload = verifyAndGetPayload(tokenGoogle);

        String email = payload.getEmail();
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            User userResponse=userRepository.findByEmail(email).get();
            String TOKEN=jwtTokenProvider.generateToken(existingUser.get());
             return buildResponseMap(userResponse,TOKEN);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public String registerUser(UserDto userDto) {
        try{
            User user = User.builder()
                    .lastName(userDto.getLastName())
                    .firstName(userDto.getFirstName())
                    .email(userDto.getEmail())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .build();
            System.out.println(":::::::::::::=>>>  "+RoleName.USER.name());
            Role userRole = roleRepository.findByName(RoleName.USER);
            user.setRoles(Set.of(userRole));
            userRepository.save(user);
            return "User registered successfully with role USER";
        }catch (Exception e){
            return "Failed to register user";
        }
    }


    @Override
    public Map<String, String> authenticateUser(AuthRequest authRequest) {
        Optional<User> userOptional= this.userRepository.findByEmail(authRequest.getEmail());
        if (userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userOptional.get();
         Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );
         if(!authentication.isAuthenticated()){
             throw new UserNotAuthorization("Invalid email or password");
         }
        final String jwt = jwtTokenProvider.generateToken(authentication);
         return buildResponseMap(user, jwt);
    }

    /**
     * Verifies a Google ID token and returns its payload
     *
     * Validates the token against a specific audience Returns the payload if valid;
     * otherwise, throws an exception
     *
     * @param token the Google ID token to verify
     * @return the payload of the verified token
     * @throws InvalidTokenOfGoogleException if the token is invalid
     * @throws RuntimeException if verification fails
     */
    private GoogleIdToken.Payload verifyAndGetPayload(String token) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
                    .setAudience(Collections.singletonList(clientIdGoogle))
                    .build();
            GoogleIdToken idToken = verifier.verify(token);
            if (idToken != null) {
                return idToken.getPayload();
            } else {
                throw new InvalidTokenOfGoogleException("Invalid token not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Google token validation failed.", e);
        }
    }
    /**
     * Generates a response map containing user details and a JWT token
     *
     * @param userResponse The user object containing details
     * @param token The JSON Web Token for authentication
     * @return A map with user details and token
     */
    private Map<String, String> buildResponseMap(User userResponse, String token){
        Map<String, String> response=new HashMap<String, String>();
        response.put("jwt", token);
        response.put("id", String.valueOf(userResponse.getId()));
        response.put("firstName", userResponse.getFirstName());
        response.put("lastName", userResponse.getLastName());
        response.put("email", userResponse.getEmail());
        response.put("roles", userResponse.getRoles().stream()
                .map(role -> role.getName().toString())
                .collect(Collectors.joining(", ")));
        return response;
    }


}
