package com.cybage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.pojos.AllPlansInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Plans;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;


public class ManagerServlet extends HttpServlet {
	
	ManagerServiceI manager=new ManagerServiceImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside the manager servlet");
		String path = request.getPathInfo();
		
		if(path.equals("/listplan")) {			
			try {
				List<AllPlansInfo> listplan=manager.getAllPlans();
				
				request.setAttribute("plans", listplan);
				request.getRequestDispatcher("/manager/manager-plans.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/addplan")) {			
			try {
				Plans planinfo= new Plans();
				
				planinfo.setSportId(Integer.parseInt(request.getParameter("sportId")));
				planinfo.setPlanName(request.getParameter("planName"));
				planinfo.setFees(Double.parseDouble(request.getParameter("fees")));
				planinfo.setDuration(Integer.parseInt(request.getParameter("duration")));
				
				manager.addPlan(planinfo);
				response.sendRedirect("listplan");								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/deleteplan")) {			
			try {
				manager.removePlan(Integer.parseInt(request.getParameter("planId")));
	
				request.setAttribute("deletemsg", "Batch deleted successfully");
				response.sendRedirect("listplan");								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if(path.equals("/editplan")) {			
			try {
				Plans plan=manager.getPlan(Integer.parseInt(request.getParameter("planId")));
				
				request.setAttribute("plans", plan);
				request.getRequestDispatcher("/manager/update-plan.jsp").forward(request, response);								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/updateplan")) {			
			try {
				
				Plans planinfo= new Plans();
				
				planinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				planinfo.setSportId(Integer.parseInt(request.getParameter("sportId")));
				planinfo.setPlanName(request.getParameter("planName"));
				planinfo.setFees(Double.parseDouble(request.getParameter("fees")));
				planinfo.setDuration(Integer.parseInt(request.getParameter("duration")));
				
				manager.addPlan(planinfo);
				response.sendRedirect("listplan");												
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}


}

	

