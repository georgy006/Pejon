-- Заполнение таблицы warehouse (Склады)
INSERT INTO warehouse (name, count_line) VALUES
('Main Warehouse', 3),
('Secondary Warehouse', 2);

-- Заполнение таблицы line (Линии)
INSERT INTO line (name, count_shelf, warehouse_id) VALUES
('Line A', 5, 1),
('Line B', 4, 1),
('Line C', 3, 2);

-- Заполнение таблицы storage (Хранилища)
INSERT INTO storage (name, capacity) VALUES
('Container 1', 6),
('Container 2', 6),
('Shelf 1', 6),
('Shelf 2', 6),
('Zone 1', 6),
('Zone 2', 6);

-- Заполнение таблицы shelf (Полки)
INSERT INTO shelf (id, line_id) VALUES
((SELECT id FROM storage WHERE name = 'Shelf 1'), 1),
((SELECT id FROM storage WHERE name = 'Shelf 2'), 2);

-- Заполнение таблицы floor_zone (Зоны на складе)
INSERT INTO floor_zone (id, warehouse_id) VALUES
((SELECT id FROM storage WHERE name = 'Zone 1'), 1),
((SELECT id FROM storage WHERE name = 'Zone 2'), 2);

-- Заполнение таблицы container (Контейнеры)
INSERT INTO container (id) VALUES
((SELECT id FROM storage WHERE name = 'Container 1')),
((SELECT id FROM storage WHERE name = 'Container 2'));

-- Заполнение таблицы transport_container (Транспортные контейнеры)
INSERT INTO transport_container (name) VALUES
('Refrigerated Truck'),
('Standard Cargo');

-- Заполнение таблицы role (Роли пользователей)
INSERT INTO role (name) VALUES
('Admin'),
('Manager'),
('Worker');

-- Заполнение таблицы user_table (Пользователи)
INSERT INTO user_table (name, login, password, role_id) VALUES
('Alice', 'alice123', 'password1', 1),
('Bob', 'bob456', 'password2', 2),
('Charlie', 'charlie789', 'password3', 3);

-- Заполнение таблицы cell (Ячейки)
-- Дополнительные ячейки в контейнерах
INSERT INTO cell (name, description, transport_container_id, storage_id) VALUES
('Cell 103', 'Meat storage', 1, (SELECT id FROM storage WHERE name = 'Container 1')),
('Cell 104', 'Seafood storage', 1, (SELECT id FROM storage WHERE name = 'Container 1')),
('Cell 105', 'Canned goods', 2, (SELECT id FROM storage WHERE name = 'Container 2')),
('Cell 106', 'Dry pasta', 2, (SELECT id FROM storage WHERE name = 'Container 2'));

-- Дополнительные ячейки на полках
INSERT INTO cell (name, description, transport_container_id, storage_id) VALUES
('Cell 107', 'Boxed cereals', 1, (SELECT id FROM storage WHERE name = 'Shelf 1')),
('Cell 108', 'Baking ingredients', 2, (SELECT id FROM storage WHERE name = 'Shelf 1')),
('Cell 109', 'Cleaning supplies', 1, (SELECT id FROM storage WHERE name = 'Shelf 2')),
('Cell 110', 'Paper products', 2, (SELECT id FROM storage WHERE name = 'Shelf 2'));

-- Дополнительные ячейки на полу (в зонах)
INSERT INTO cell (name, description, transport_container_id, storage_id) VALUES
('Cell 111', 'Oversized items', 1, (SELECT id FROM storage WHERE name = 'Zone 1')),
('Cell 112', 'Pallets of water', 2, (SELECT id FROM storage WHERE name = 'Zone 1')),
('Cell 113', 'Construction tools', 1, (SELECT id FROM storage WHERE name = 'Zone 2')),
('Cell 114', 'Paint buckets', 2, (SELECT id FROM storage WHERE name = 'Zone 2'));

-- Заполнение таблицы type (Типы заявок)
INSERT INTO type (name, terminal) VALUES
('Delivery', FALSE),
('Storage', TRUE);

-- Заполнение таблицы status (Статусы заявок)
INSERT INTO status (name, terminal) VALUES
('Pending', FALSE),
('Completed', TRUE);

-- Заполнение таблицы application (Заявки)
INSERT INTO application (title, description, data, type_id, cell_id, status_id, author_id, approver_id) VALUES
('Incoming Shipment', 'New shipment of goods', '2025-04-01', 1, 1, 1, 1, 2),
('Storage Request', 'Need extra space for dry goods', '2025-04-02', 2, 2, 2, 2, 3);
