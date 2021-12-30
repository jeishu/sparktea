package com.project.sparktea.controller;

public class SparkDataController {
	
//private static final Logger logger = Logger.getLogger(ReimbursementController.class);

	
/*	public static Handler getSparkData = ctx -> {
		logger.info("Initializing ctx sparkData.");
		ReimbursementsDaoHibernate rbdao = new ReimbursementsDaoHibernate();
		ctx.json(rbdao.getAllReimbursements());
	};


	public static Handler insertReimbursements = ctx -> {
		logger.info("inserting reimbursements.....");
		// author id
		int id = ctx.cookieStore("id");
		Reimbursement rm = new Reimbursement();

	
		ReimbursementsDaoHibernate rbdao = new ReimbursementsDaoHibernate();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String reimbursementtype = ctx.formParam("reimbursement-type");
		String description = ctx.formParam("description-area");
		int amount = Integer.parseInt(ctx.formParam("amount"));
		int randomNum = ReimbursementServices.generateRandomNum();
		rm.setReimbursementId(randomNum);
		rm.setAccepted(false);
		rm.setAmount(amount);
		rm.setDescription(description);
		rm.setReimbursementType(reimbursementtype);
		rm.setResolveTime(null);
		rm.setResolved(false);
		rm.setSubmitTime(dateFormat.format(date));
		rm.setAuthorId(id);

		rbdao.insertReimbursements(rm);
		ctx.redirect("/employeepage.html");
	};

	public static Handler approveOrDeny = ctx -> {
		logger.info("Aprroving or denying reimbursements...");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int id = ctx.cookieStore("id");
		Reimbursement rm = new Reimbursement();
		ReimbursementsDaoHibernate rbdao = new ReimbursementsDaoHibernate();
		String reimbursementId = ctx.formParam("reimbursement-id");
		String resolvedTime = dateFormat.format(date);
		String reimbursementOption = ctx.formParam("reimbursement-option");
		boolean accepted;
		if (reimbursementOption.equals("true")) {
			accepted = true;
			logger.info("reimbursement approved");
		} else {
			logger.info("reimbursement denied");
			accepted = false;
		}
		rm.setResolverId(id);
		rm.setReimbursementId(Integer.parseInt(reimbursementId));
		rm.setResolveTime(resolvedTime);
		rm.setAccepted(accepted);
		rbdao.updateReimbursements(rm);
		ctx.redirect("./reimbursements.html");
	};
}


*/
}   
