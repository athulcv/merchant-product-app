package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {
	public static void main(String[] args) {
		MerchantDao merchantDao = new MerchantDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Find Merchant By Id");
		System.out.println("4.Verify Merchant By Phone number and Password");
		System.out.println("5.Verify Merchant By Email and Password");
		System.out.println("-----------------------------------------------");
		System.out.println("Enter your choice :");
		switch (sc.nextInt()) {
		case 1: {
			Merchant merchant = new Merchant();
			System.out.println("Enter Merchant name :");
			merchant.setName(sc.next());
			System.out.println("Enter Phone number :");
			merchant.setPhone(sc.nextLong());
			System.out.println("Enter Email address :");
			merchant.setEmail(sc.next());
			System.out.println("Enter Gst_number :");
			merchant.setGst_number(sc.next());
			System.out.println("Create password :");
			merchant.setPassword(sc.next());
			merchant = merchantDao.saveMerchant(merchant);
			System.out.println("Merchant saved with Id : " + merchant.getId());
			break;
		}
		case 2: {
			Merchant merchant = new Merchant();
			System.out.println("Enter the Merchant id to update details :");
			merchant.setId(sc.nextInt());
			System.out.println("Enter the updated Merchant name :");
			merchant.setName(sc.next());
			System.out.println("Enter the updated Phone number :");
			merchant.setPhone(sc.nextLong());
			System.out.println("Enter the updated Email address :");
			merchant.setEmail(sc.next());
			System.out.println("Enter the updated Gst_number :");
			merchant.setGst_number(sc.next());
			System.out.println("Enter the updated password :");
			merchant.setPassword(sc.next());
			merchant = merchantDao.updateMerchant(merchant);
			if (merchant != null) {
				System.out.println("Merchant updated successfully :)");
			} else {
				System.err.println("Invalid Merchant id..!");
			}
			break;
		}
		case 3: {
			System.out.println("Enter the Merchant id :");
			int id = sc.nextInt();
			Merchant merchant = merchantDao.findMerchantById(id);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Merchant id..!");
			}

			break;
		}
		case 4: {
			System.out.println("Enter the Phone number and Password to verify Merchant");
			long phone = sc.nextLong();
			String password = sc.next();
			Merchant merchant = merchantDao.verifyMerchant(phone, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Phone number or password..!");
			}
			break;
		}
		case 5: {
			System.out.println("Enter the Email address and Password to verify Merchant");
			String email = sc.next();
			String password = sc.next();
			Merchant merchant = merchantDao.verifyMerchant(email, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Email address or password..!");
			}
			break;
		}
		default:
			break;
		}
	}
}
