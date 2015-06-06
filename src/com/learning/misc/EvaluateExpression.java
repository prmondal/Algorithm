package com.learning.misc;

public class EvaluateExpression {
	static int curr = 0;
	static int sum = 24;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		findExpressionUtil(nums, nums.length - 1, new StringBuilder());
	}

	static void findExpressionUtil(int[] nums, int h, StringBuilder res) {
		res.append(nums[0]);
		int l = res.length();

		findExpression(nums, 1, h, curr + nums[0], res, '+');
		res.setLength(l);

		findExpression(nums, 1, h, curr + nums[0], res, '-');
		res.setLength(l);
	}

	static void findExpression(int[] nums, int l, int h, int curr,
			StringBuilder res, char op) {
		if (l > h)
			return;

		if (op == '+') {
			curr = curr + nums[l];
			res.append("+" + nums[l]);
		} else if (op == '-') {
			curr = curr - nums[l];
			res.append("-" + nums[l]);
		}

		if (curr == sum) {
			System.out.println(res);
			return;
		}

		int len = res.length();

		findExpression(nums, l + 1, h, curr, res, '+');
		res.setLength(len);

		findExpression(nums, l + 1, h, curr, res, '-');
		res.setLength(len);
	}
}
