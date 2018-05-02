package com.renu.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.renu.shoppingBackend.dao.CategoryDAO;
import com.renu.shoppingBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.renu.shoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Mobile");
	 * category.setDescription("This is some description for mobile");
	 * category.setImageUrl("CAT_2.png");
	 * 
	 * assertEquals("Successfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category=categoryDAO.get(4);
	 * 
	 * assertEquals("Successfully get a category from the table", "Mobile",
	 * category.getName());
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testUpdateCategory() { category=categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("Successfully update a category category in  the table",true,
	 * categoryDAO.update(category));
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("Successfully delete a category category in  the table", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully get list a category from  the table",2,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testCRUDCategory() {
		// add

		category = new Category();

category = new Category();

		
		
		/*category.setName("Laptop");
		category.setDescription("This is some description for Laptop");
		category.setImageUrl("CAT_14.png");

		category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageUrl("CAT_15.png");

		
		
		
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
*/
		
		// update
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully update a category category in  the table", true, categoryDAO.update(category));

		// delete

		assertEquals("Successfully delete a category category in  the table", true, categoryDAO.delete(category));

		// list

		assertEquals("Successfully get list a category from  the table", 3, categoryDAO.list().size());

	}

}
