/* Consulta 1*/
SELECT DISTINCT p.nombre FROM pacientes p
                                  JOIN citas c ON p.id = c.paciente_id
                                  JOIN doctores d ON d.id = c.doctor_id
WHERE experiencia > 10
ORDER BY nombre;

/* Consulta 2*/
SELECT hc.diagnostico, COUNT(hc.diagnostico) AS cantidad FROM historia_clinica hc
                                                                  JOIN pacientes p ON hc.paciente_id = p.id
GROUP BY diagnostico;

/*Consulta 3*/
SELECT e.nombre, AVG(f.monto) AS promedio FROM facturas f
                                                   JOIN citas c ON f.id = c.factura_id
                                                   JOIN doctores d ON c.doctor_id = d.id
                                                   JOIN especialidades e ON d.especialidad_id = e.id
GROUP BY e.nombre
ORDER BY promedio DESC;

/*Consulta 4*/
SELECT d.nombre, p.nombre FROM doctores d
                                   JOIN citas c ON d.id = c.doctor_id
                                   JOIN pacientes p ON c.paciente_id = p.id
ORDER BY d.nombre;

/*Consulta 5*/
SELECT d.nombre, SUM(f.monto) AS Total_facturado FROM doctores d
                                                          JOIN citas c ON d.id = c.doctor_id
                                                          JOIN facturas f ON c.factura_id = f.id
GROUP BY d.nombre
ORDER BY Total_facturado DESC;

