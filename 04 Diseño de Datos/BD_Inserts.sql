insert into clientes values(1, 'Jesus Alvarado', '123456', 'JesusUsuario', '73456712', '974874521');
insert into clientes values(2, 'Enrique Acevedo', '123456', 'EnriqueUsuario', '72146321', '987452167');
insert into clientes values(3, 'Irma Aguilar', '123456', 'IrmaUsuario', '69874541', '954780123');
insert into clientes values(4, 'Fredy Acosta', '123456', 'FredyUsuario', '70154213', '98741254');
insert into clientes values(5, 'Adolfo Alderete', '123456', 'AdolfoUsuario', '68745596', '965478852');
insert into clientes values(6, 'Victor Hugo Baltazar', '123456', 'VictorUsuario', '71245325', '954123678');
insert into clientes values(7, 'Juan Caballero', '123456', 'JuanUsuario', '71458792', '998745545');
insert into clientes values(8, 'Marcos Cardona', '123456', 'MarcosUsuario', '72031458', '945443621');
insert into clientes values(9, 'Luis Castro', '123456', 'LuisUsuario', '74589621', '97441123');
insert into clientes values(10, 'Jesús Cuellar', '123456', 'JessyUsuario', '73557889', '999521002');
insert into clientes values(11, 'Roberto De La Fuente', '123456', 'RobertoUsuario', '69225478', '987441436');
insert into clientes values(12, 'Adán De Lira', '123456', 'AdanUsuario', '68541123', '963362584');
insert into clientes values(13, 'Vicente Díaz', '123456', 'VicenteUsuario', '71412458', '954123698');
insert into clientes values(14, 'Romo Dominguez', '123456', 'RomoUsuario', '70125336', '987654321');
insert into clientes values(15, 'Ángel Ferreira', '123456', 'AngelUsuario', '71102365', '987321654');
insert into clientes values(16, 'Ernesto Altamirano', '123456', 'ErnestoUsuario', '73216599', '963852741');
insert into clientes values(17, 'Fernando Gallegos', '123456', 'FernandoUsuario', '72100012', '963741852');
insert into clientes values(18, 'Carlos García', '123456', 'CarlosUsuario', '69992214', '951753654');
insert into clientes values(19, 'Jorge Gamarra', '123456', 'JorgeUsuario', '71452365', '987455541');
insert into clientes values(20, 'Alberto Huaman', '123456', 'AlbertoUsuario', '73321444', '95566644');

insert into usuarios values(1, '1985-12-15', 'Nora Giggs', '56478541', 4);
insert into usuarios values(2, '1970-01-31', 'Mario Gutierre<', '54714245', 3);
insert into usuarios values(3, '1960-04-14', 'Juan Manuel Rosas', '68745741', 1);
insert into usuarios values(4, '1955-04-28', 'Benjamin Rezza', '54785214', 10);
insert into usuarios values(5, '1953-07-17', 'Laura Mamani', '52817436', 11);
insert into usuarios values(6, '1961-02-24', 'Courtis Connor', '55214112', 12);
insert into usuarios values(7, '1952-11-29', 'Pedro Martinez', '44741452', 17);
insert into usuarios values(8, '1950-12-25', 'Julio Diaz', '57896541', 20);
insert into usuarios values(9, '1952-10-20', 'Miriam Anticona', '56644578', 7);
insert into usuarios values(10, '1953-08-12', 'Thomas Martinoli', '44778545', 2);

insert into enfermedades values(1, 'Alzheimer', 'Deterioro de memoria');
insert into enfermedades values(2, 'Parkinson', 'Enfermedad progresiva que afecta el sistema nevioso');
insert into enfermedades values(3, 'Artritis', 'Inflamacion de las articulaciones de los huesos');
insert into enfermedades values(4, 'Hipertension Arterial', 'Aumento elevado de la presion arterial');
insert into enfermedades values(5, 'Diabetes', 'Exceso de glucosa en la sangre');
insert into enfermedades values(6, 'Desnutricion', 'Debilitacion del organismo debido a la baja ingesta de alimentos');
insert into enfermedades values(7, 'Hipertrofia de Prostata', 'Crecimiento excesivo de la prostata');
insert into enfermedades values(8, 'Osteoporosis', 'Disminucion de minerales en los huesos');
insert into enfermedades values(9, 'Infarto', 'Riesgo de infarto');
insert into enfermedades values(10, 'Accidente Cerebro Vascular (ICTUS)', 'Daño cerebral causado por la obstruccion del flujo de sangre al cerebro');

insert into usuario_enfermedades values (1, 1, 2);
insert into usuario_enfermedades values (2, 2, 4);
insert into usuario_enfermedades values (3, 3, 1);
insert into usuario_enfermedades values (4, 4, 6);
insert into usuario_enfermedades values (5, 5, 7);
insert into usuario_enfermedades values (6, 6, 8);
insert into usuario_enfermedades values (7, 7, 5);
insert into usuario_enfermedades values (8, 8, 3);
insert into usuario_enfermedades values (9, 9, 10);
insert into usuario_enfermedades values (10, 10, 9);

insert into grados values(1, 'Técnico Profesional');
insert into grados values(2, 'Bachiller');
insert into grados values(3, 'Maestría');
insert into grados values(4, 'Doctorado');

insert into enfermeros values(1, '654321', '72145235', true, 'Adam West', 4.6, 'AdamEnfermero', 'Alta disponibilidad', '987454574', 1);
insert into enfermeros values(2, '654321', '72312321', true, 'Tom Cruise', 4.5, 'TomEnfermero', 'Buen trato', '974147412', 3);
insert into enfermeros values(3, '654321', '69856321', true, 'Eva Palacios', 4.7, 'EvaEnfermera', 'Paciencia y hostidad', '963254125', 4);
insert into enfermeros values(4, '654321', '63254121', true, 'Walter Pacheco', 4.9, 'WalterEnfermero', 'Calidez humana', '965541141', 2);
insert into enfermeros values(5, '654321', '66332147', true, 'Jose Campos', 4.9, 'JoseEnfermero', 'Responsabilidad en las citas', '985544455', 3);
insert into enfermeros values(6, '654321', '72225474', true, 'Pepito Suarez', 4.8, 'PepitoEnfermero', 'Experiencia en el trabajo', '963254147', 2);
insert into enfermeros values(7, '654321', '71444121', true, 'Monica Dosantos', 4.5, 'MonicaEnfermera', 'Comodidad y seguridad', '949958785', 2);
insert into enfermeros values(8, '654321', '75544114', true, 'Susan Sinatra', 4.6, 'SusanEnfermera', 'Calidad desde el primer segundo', '966632477', 1);
insert into enfermeros values(9, '654321', '73558565', true, 'Alicia Arnao', 4.7, 'AliciaEnfermera', 'Seguridad en el servicio', '955544447', 3);
insert into enfermeros values(10, '654321', '69998713', true, 'Milagros Tucuman', 4.8, 'MilagrosEnfermera', 'Garantía de buen servicio', '914474632', 4);

insert into especialidades values(1, 'Ostetrico-Ginecologica');
insert into especialidades values(2, 'Salud Mental');
insert into especialidades values(3, 'Trabajo');
insert into especialidades values(4, 'Geriatrica');
insert into especialidades values(5, 'Cuidados Medico-Quirurgicos');
insert into especialidades values(6, 'Familiar y Comunitaria');
insert into especialidades values(7, 'Pediatrica');

insert into enfermero_especialidades values(1, 1, 7);
insert into enfermero_especialidades values(2, 2, 6);
insert into enfermero_especialidades values(3, 3, 4);
insert into enfermero_especialidades values(4, 4, 3);
insert into enfermero_especialidades values(5, 5, 2);
insert into enfermero_especialidades values(6, 6, 1);
insert into enfermero_especialidades values(7, 7, 2);
insert into enfermero_especialidades values(8, 8, 5);
insert into enfermero_especialidades values(9, 9, 4);
insert into enfermero_especialidades values(10, 10, 3);

insert into contratos values(1, false, 'Av. Los Manglares 541', 2, 1);
insert into contratos values(2, false, 'Jr. Union 125', 1, 2);
insert into contratos values(3, false, 'Av. Cornejo 447', 5, 3);
insert into contratos values(4, false, 'Av. Salaverry 105', 4, 4);
insert into contratos values(5,  false, 'Av. Universitaria 1478', 3, 5);
insert into contratos values(6, false, 'Calle Einstein 774', 10, 6);
insert into contratos values(7, false, 'Jr. Ciclope 369', 5, 7);
insert into contratos values(8, false, 'Av. Washington 147', 4, 8);
insert into contratos values(9, false, 'Calle Grau 555', 7, 9);
insert into contratos values(10, false, 'Av. Abancay 357', 8, 10);
insert into contratos values(11, false, 'Av. Los Manglares 541', 2, 1);
insert into contratos values(12, false, 'Jr. Union 125', 6, 2);
insert into contratos values(13, false, 'Av. Cornejo 447', 9, 3);
insert into contratos values(14, false, 'Av. Salaverry 105', 10, 4);
insert into contratos values(15, false, 'Av. Universitaria 1478', 7, 5);
insert into contratos values(16, false, 'Calle Einstein 774', 1, 6);
insert into contratos values(17, false, 'Jr. Ciclope 369', 6, 7);
insert into contratos values(18, false, 'Av. Washington 147', 5, 8);
insert into contratos values(19, false, 'Calle Grau 555', 2, 9);
insert into contratos values(20, false, 'Av. Abancay 357', 8, 10);

insert into tipoactividades values(1, 'Terapia Fisica');
insert into tipoactividades values(2, 'Terapia Cognitiva');
insert into tipoactividades values(3, 'Analisis y Control');
insert into tipoactividades values(4, 'Cuidado Personal');
insert into tipoactividades values(5, 'Administracion de medicamentos y/o inyecciones');
insert into tipoactividades values(6, 'Otros');

insert into actividades values(1, 'Masajes', 'Masajes en el cuerpo', 1, 1);
insert into actividades values(2, 'Ejercicios de Memoria', 'Juegos recreativos y demas', 2, 2);
insert into actividades values(3, 'Aseado', 'Bañado del paciente', 3, 4);
insert into actividades values(4, 'Inyeccion', 'Aplicar Inyecciones correspondientes', 4, 5);
insert into actividades values(5, 'Traslado del paciente', 'Traslado del paciente al centro de salud', 5, 6);
insert into actividades values(6, 'Traslado del paciente', 'El paciente es trasladado a su casa', 6, 6);
insert into actividades values(7, 'Fisioterapia Respiratoria', 'Se realiza fisioterapia al paciente', 7, 1);
insert into actividades values(8, 'Otros', 'Otro tipo de actividad', 8, 6);
insert into actividades values(9, 'Medicion de Constantes Vitales', 'Control de los signos vitales del paciente', 9, 3);
insert into actividades values(10, 'Inyeccion', 'Aplicar las inyecciones al paciente', 10, 5);
insert into actividades values(11, 'Aseado', 'Se necesita que se bañe al cliente', 11, 4);
insert into actividades values(12, 'Alimentacion', 'Alimentacion del cliente durante la tarde', 12, 4);
insert into actividades values(13, 'Compañia', 'El paciente requiere de compañia del enfermero', 13, 4);
insert into actividades values(14, 'Oxigenoterapia', 'Oxigenoterapia al paciente', 14, 1);
insert into actividades values(15, 'Realizar tendido de cama', 'Se requiere el tendido de cama del paciente', 15, 6);
insert into actividades values(16, 'Aerosolterapia', 'Aerosolterapia al paciente', 16, 1);
insert into actividades values(17, 'Mecánica Corporal', 'Ejercicios psicomotrices de mecanica corporal', 17, 1);
insert into actividades values(18, 'Aplicacion de calor', 'Terapia de aplicacion de calor al cliente', 18, 1);
insert into actividades values(19, 'Aplicacion de frio', 'Terapia de aplicacion de frio al cliente', 19, 1);
insert into actividades values(20, 'Masajes', 'Masajes en el torso', 20, 1);

insert into diacontratos values(1, '2019-11-20', '14:00:00', '16:00:00', 2);
insert into diacontratos values(2, '2019-11-21', '16:00:00', '18:00:00', 4);
insert into diacontratos values(3, '2019-11-19', '12:00:00', '14:00:00', 6);
insert into diacontratos values(4, '2019-11-18', '08:00:00', '10:00:00', 10);
insert into diacontratos values(5, '2019-11-19', '09:00:00', '11:00:00', 18);
insert into diacontratos values(6, '2019-11-24', '07:00:00', '09:00:00', 1);
insert into diacontratos values(7, '2019-11-25', '08:00:00', '10:00:00', 19);
insert into diacontratos values(8, '2019-11-26', '14:00:00', '16:00:00', 3);
insert into diacontratos values(9, '2019-11-23', '16:00:00', '18:00:00', 12);
insert into diacontratos values(10, '2019-11-21', '15:00:00', '17:00:00', 13);
insert into diacontratos values(11, '2019-11-22', '13:00:00', '15:00:00', 5);
insert into diacontratos values(12, '2019-11-27', '10:00:00', '12:00:00', 14);
insert into diacontratos values(13, '2019-11-14', '16:00:00', '18:00:00', 9);
insert into diacontratos values(14, '2019-11-16', '12:00:00', '14:00:00', 15);
insert into diacontratos values(15, '2019-11-15', '18:00:00', '20:00:00', 17);
insert into diacontratos values(16, '2019-11-19', '07:00:00', '09:00:00', 7);
insert into diacontratos values(17, '2019-11-20', '09:00:00', '11:00:00', 20);
insert into diacontratos values(18, '2019-11-18', '12:00:00', '14:00:00', 8);
insert into diacontratos values(19, '2019-11-12', '08:00:00', '10:00:00', 11);
insert into diacontratos values(20, '2019-11-30', '14:00:00', '16:00:00', 16);

insert into tiporeclamos values(1, 'Inasistencia');
insert into tiporeclamos values(2, 'Tardanza');
insert into tiporeclamos values(3, 'Mal trato');
insert into tiporeclamos values(4, 'Bajo rendimiento del enfermero');
insert into tiporeclamos values(5, 'Problema y/o dificultad con los implementos');
insert into tiporeclamos values(6, 'Otros');

insert into reclamos values(1, '2019-11-05 17:51:04', 'El cuidador no se presento a la sesion', 5, 1);
insert into reclamos values(2, '2019-10-27 14:24:11', 'No hubo muy buen trato', 10, 3);
insert into reclamos values(3, '2019-11-01 11:33:57', 'El enfermero no hizo un trabajo muy bueno', 12, 4);
insert into reclamos values(4, '2019-11-03 18:45:31', 'El enfermero llego muy tarde a la sesion', 1, 2);
insert into reclamos values(5, '2019-10-25 10:58:28', 'Mi familiar se quejo del enfermero', 18, 4);
insert into reclamos values(6, '2019-09-30 09:17:20', 'Parece que el enfermero no esterilizo la aguja para inyecciones', 9, 5);
insert into reclamos values(7, '2019-10-19 12:32:19', 'Inasistencia del enfermero', 7, 1);
