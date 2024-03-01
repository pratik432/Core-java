package Lis;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerdemo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("case started "+result.getStatus());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Successful "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed "+result.getTestName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		
	}

}
