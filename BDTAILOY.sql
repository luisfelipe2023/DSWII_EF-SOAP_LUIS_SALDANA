

-- Crear tabla Categoria
CREATE TABLE Categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear tabla Proveedor
CREATE TABLE Proveedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100) NOT NULL
);

-- Crear tabla Producto
CREATE TABLE Producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    categoria_id BIGINT,
    proveedor_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id),
    FOREIGN KEY (proveedor_id) REFERENCES Proveedor(id)
);

drop table cliente

-- Crear tabla Cliente
CREATE TABLE Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
  
);

-- Crear tabla Pedido
CREATE TABLE Pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    producto_id BIGINT,
    cantidad INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (producto_id) REFERENCES Producto(id)
);

-- Insertar datos en la tabla Categoria
INSERT INTO Categoria (nombre) VALUES
('Útiles Escolares'),
('Artículos de Oficina'),
('Papelería'),
('Tecnología'),
('Accesorios'),
('Libros'),
('Material de Arte'),
('Suministros');

-- Insertar datos en la tabla Proveedor
INSERT INTO Proveedor (nombre, contacto) VALUES
('Distribuidora ABC', 'Carlos Martínez'),
('Papelería XYZ', 'Ana Rodríguez'),
('Materiales LMN', 'Pedro Jiménez'),
('Impresos QRS', 'María Pérez'),
('Artículos Escolares JKL', 'Laura Fernández'),
('Tecnología Innovativa', 'Luis Hernández'),
('Accesorios MNO', 'Sofia Sánchez'),
('Servicios Integrales PQR', 'Ana López');

-- Insertar datos en la tabla Producto
INSERT INTO Producto (nombre, precio, stock, categoria_id, proveedor_id) VALUES
('Cuaderno A4', 5.50, 150, 1, 1),
('Bolígrafo BIC', 1.20, 200, 1, 2),
('Carpetas plásticas', 2.75, 100, 1, 3),
('Resaltadores Stabilo', 3.00, 120, 1, 4),
('Post-it 3M', 4.50, 80, 1, 5),
('Laptop HP', 1200.00, 30, 4, 6),
('Impresora Canon', 150.00, 20, 4, 7),
('Lápiz HB', 0.60, 250, 1, 8),
('Marcadores permanentes', 5.00, 70, 3, 1),
('Agenda 2024', 10.00, 40, 2, 2),
('Tijeras escolares', 4.00, 60, 1, 3),
('Grapadora', 15.00, 45, 2, 4);


-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (nombre, email) VALUES 
('Juan Pérez', 'juan.perez@tailoy.com'),
('María López', 'maria.lopez@tailoy.com'),
('Carlos García', 'carlos.garcia@tailoy.com');


