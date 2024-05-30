package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Product;

public class ProductController {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Product");
		System.out.println("2.Update Product");
		System.out.println("3.Find Products By Merchant Id");
		System.out.println("4.Find Products By Brand");
		System.out.println("5.Find Products By Category");
		System.out.println("-------------------------------");
		System.out.println("Enter your choice :");
		switch (sc.nextInt()) {
		case 1: {
			Product product = new Product();
			System.out.println("Enter Merchant Id to add product :");
			int merchant_id = sc.nextInt();
			System.out.println("Enter product name :");
			product.setName(sc.next());
			System.out.println("Enter Brand name :");
			product.setBrand(sc.next());
			System.out.println("Enter Category :");
			product.setCategory(sc.next());
			System.out.println("Enter Product Description :");
			product.setDescription(sc.next());
			System.out.println("Enter Image url :");
			product.setImage_url(sc.next());
			System.out.println("Enter Product cost :");
			product.setCost(sc.nextDouble());
			product = productDao.saveProduct(product, merchant_id);
			if (product != null) {
				System.out.println("Product added with Id :" + product.getId());
			} else {
				System.err.println("Cannot add product as Merchant Id is invalid..!");
			}
			break;
		}
		case 2: {
			Product product = new Product();
			System.out.println("Enter Product id to upadte the details :");
			product.setId(sc.nextInt());
			System.out.println("Enter Product Name, Brand name, Category, Description, Image url & Cost :");
			product.setName(sc.next());
			product.setBrand(sc.next());
			product.setCategory(sc.next());
			product.setDescription(sc.next());
			product.setImage_url(sc.next());
			product.setCost(sc.nextDouble());
			product = productDao.updateProduct(product);
			if (product != null) {
				System.out.println("Product updated successfully :)");
			} else {
				System.err.println("Invalid Product id..!");
			}
			break;
		}
		case 3: {
			System.out.println("Enter Merchant id to display product details :");
			int merchant_id = sc.nextInt();
			List<Product> products = productDao.findProductsByMerchantId(merchant_id);
			if (products.isEmpty()) {
				System.err.println("No products found for entered Merchant Id..!");
			} else {
				for (Product product : products) {
					System.out.println(product);
				}
			}
			break;
		}
		case 4: {
			System.out.println("Enter Brand name to find products :");
			String name = sc.next();
			List<Product> products = productDao.findByBrand(name);
			if (products.isEmpty())
				System.err.println("No products found :(");
			else
//				for (Product product : products)
					System.out.println(products);
			break;
		}
		case 5: {
			System.out.println("Enter Category to find products :");
			String category=sc.next();
			List<Product> products=productDao.findByCategory(category);
			if (products.isEmpty())
				System.err.println("No products found :(");
			else
//				for (Product product : products)
					System.out.println(products);
			break;
		}

		default:
			System.err.println("Invalid choice..!!");
		}
	}

}
