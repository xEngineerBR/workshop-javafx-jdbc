package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Department obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Department obj) {
		dao.deleteById(obj.getId());private void initRemoveButtons() { 
			tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue())); 
			tableColumnREMOVE.setCellFactory(param -> new TableCell<Department, Department>() { 
			 private final Button button = new Button("remove"); 
			 @Override
			 protected void updateItem(Department obj, boolean empty) { 
			 super.updateItem(obj, empty); 
			 if (obj == null) { 
			 setGraphic(null); 
			 return; 
			 } 
			 setGraphic(button); 
			 button.setOnAction(event -> removeEntity(obj)); 
			 } 
			 }); 
			} 
	}
}
