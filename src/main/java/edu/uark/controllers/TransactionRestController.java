package edu.uark.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.transaction.TransactionCreateCommand;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.TransactionConfirmation;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionRestController {
	@RequestMapping(value = "/CreateTransaction", method = RequestMethod.POST)
	public TransactionConfirmation createTransaction(@RequestBody Transaction transaction) {  //Task3.3 create transaction endpoint
		return (new TransactionCreateCommand()).
			setTransaction(transaction).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (TransactionRestController)";
	}
}