package app;
import dao.PhongDAO;
import db.Connection;
import entities.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		EntityManager em = Connection.getInstance().getEntityManagerFactory().createEntityManager();

		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();

		}

		PhongDAO phongDAO = new PhongDAO();

		// Tìm một phòng dựa trên mã phòng
//		int maPhongCanTim = 1;
//		Phong phongTimDuoc = phongDAO.findOne(maPhongCanTim);
//		if (phongTimDuoc != null) {
//			System.out.println("Phòng được tìm thấy: " + phongTimDuoc);
//		} else {
//			System.out.println("Không tìm thấy phòng có mã: " + maPhongCanTim);
//		}

		// Lấy danh sách tất cả các phòng
		List<Phong> danhSachPhong = phongDAO.findAll();
		if (!danhSachPhong.isEmpty()) {
			System.out.println("Danh sách các phòng:");
			for (Phong p : danhSachPhong) {
				System.out.println(p);
			}
		} else {
			System.out.println("Không có phòng nào trong danh sách.");
		}

	}
}
