package main;

import java.util.List;

import dao.MyBatisImpl.PlanesDAO;
import menu.DatabaseMenu;
import menu.Menu;
import model.Planes;

public class Executor {

	public static void main(String[] args) throws Exception {
		
		DatabaseMenu menu = new DatabaseMenu();
		menu.getPlanes();
		menu.getPlanesById();
		menu.deletePlane();
		
//		Menu menu = new Menu();
//		menu.ShowMenu();
	}
}
