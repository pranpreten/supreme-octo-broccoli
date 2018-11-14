package kr.or.ddit.web.calculate;

@FunctionalInterface
public interface RealOperator {
	
	public int operate(int leftOp, int rightOp);
	
}
