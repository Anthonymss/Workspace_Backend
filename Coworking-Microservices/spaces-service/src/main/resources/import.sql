-- Equipments (Equipos)
INSERT INTO equipments (name, description) VALUES('Proyector', 'Proyector HD para presentaciones');
INSERT INTO equipments (name, description) VALUES('Pizarra Blanca', 'Pizarra blanca con marcadores');
INSERT INTO equipments (name, description) VALUES('Sillas Ergonómicas', 'Sillas ergonómicas para mayor comodidad');
INSERT INTO equipments (name, description) VALUES('Mesa de Reunión', 'Mesa grande para reuniones de hasta 10 personas');
INSERT INTO equipments (name, description) VALUES('Micrófono', 'Micrófono inalámbrico para conferencias');
INSERT INTO equipments (name, description) VALUES('Pantalla Grande', 'Pantalla grande para proyecciones');
INSERT INTO equipments (name, description) VALUES('Cafetera', 'Cafetera de alta calidad');
INSERT INTO equipments (name, description) VALUES('Sofá', 'Sofá cómodo para área de descanso');

-- Sites (Sitios/Establecimientos)

INSERT INTO sites (name, address, city, district) VALUES('Coworking Miraflores', 'Av. Pardo y Aliaga 640', 'Lima', 'Miraflores');
INSERT INTO sites (name, address, city, district) VALUES('Coworking San Isidro', 'Av. Javier Prado 1256', 'Lima', 'San Isidro');
INSERT INTO sites (name, address, city, district) VALUES('Coworking La Molina', 'Av. La Fontana 275', 'Lima', 'La Molina');

-- Spaces (Espacios)
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Espacio Compartido 1', 'Espacio de trabajo compartido con varios escritorios', 10, 10.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 'DESK_SHARED');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Sala de Reuniones Pequeña', 'Sala de reuniones pequeña para 4 personas', 4, 30.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 'MEETING_ROOM_SMALL');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Sala de Reuniones Mediana', 'Sala de reuniones para hasta 8 personas', 8, 45.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 2, 'MEETING_ROOM_MEDIUM');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Sala de Reuniones Grande', 'Sala de reuniones para hasta 12 personas', 12, 60.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 3, 'MEETING_ROOM_LARGE');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Oficina Privada 1', 'Oficina privada para hasta 3 personas', 3, 80.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 2, 'PRIVATE_OFFICE');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Sala de Conferencias', 'Sala de conferencias con capacidad para 50 personas', 50, 150.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 'CONFERENCE_ROOM');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Salón de Eventos', 'Salón de eventos para hasta 100 personas', 100, 200.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 3, 'EVENT_HALL');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Sala de Relajación', 'Sala de relajación con cómodos asientos', 5, 25.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 1, 'RELAXATION_ROOM');
INSERT INTO spaces (name, description, capacity, price_per_hour, url_image, site_id, space_type) VALUES('Espacio Creativo', 'Espacio creativo para sesiones de brainstorming', 8, 35.00, 'https://images.unsplash.com/photo-1559310415-1e164ccd653a?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 2, 'CREATIVE_SPACE');

-- Space Equipment (Equipos por Espacio)

INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(1, 3, 1);
  INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(1, 1, 1);
  INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(1, 2, 1);
  INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(1, 4, 1);
  INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(1, 5, 1);-- Espacio Individual 1 con una Silla Ergonómica
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(2, 3, 10); -- Espacio Compartido 1 con 10 Sillas Ergonómicas
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(3, 1, 1);  -- Sala de Reuniones Pequeña con Proyector
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(3, 2, 1); -- Sala de Reuniones Pequeña con Pizarra Blanca
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(4, 1, 1);  -- Sala de Reuniones Mediana con Proyector
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(4, 2, 1);  -- Sala de Reuniones Mediana con Pizarra Blanca
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(5, 4, 1);  -- Sala de Reuniones Grande con Mesa de Reunión
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(6, 3, 3);  -- Oficina Privada 1 con Sillas Ergonómicas
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(7, 5, 1);  -- Sala de Conferencias con Micrófono
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(7, 6, 1);  -- Sala de Conferencias con Pantalla Grande
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(8, 1, 2);  -- Salón de Eventos con Proyectores
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(9, 8, 3);  -- Sala de Relajación con Sofás
INSERT INTO space_equipment (space_id, equipment_id, quantity) VALUES(10, 7, 1); -- Espacio Creativo con Cafetera