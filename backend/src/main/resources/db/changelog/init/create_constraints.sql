ALTER TABLE line ADD CONSTRAINT fk_line_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse(id);
ALTER TABLE shelf ADD CONSTRAINT fk_shelf_line FOREIGN KEY (line_id) REFERENCES line(id);
ALTER TABLE floor_zone ADD CONSTRAINT fk_zone_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse(id);

ALTER TABLE cell ADD CONSTRAINT fk_cell_transport FOREIGN KEY (transport_container_id) REFERENCES transport_container(id);
ALTER TABLE cell ADD CONSTRAINT fk_cell_storage FOREIGN KEY (storage_id) REFERENCES storage(id);

ALTER TABLE application ADD CONSTRAINT fk_app_type FOREIGN KEY (type_id) REFERENCES type(id);
ALTER TABLE application ADD CONSTRAINT fk_app_cell FOREIGN KEY (cell_id) REFERENCES cell(id);
ALTER TABLE application ADD CONSTRAINT fk_app_status FOREIGN KEY (status_id) REFERENCES status(id);
ALTER TABLE application ADD CONSTRAINT fk_app_author FOREIGN KEY (author_id) REFERENCES user_table(id);
ALTER TABLE application ADD CONSTRAINT fk_app_approver FOREIGN KEY (approver_id) REFERENCES user_table(id);

ALTER TABLE user_table ADD CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id);