package com.leetcode.study.basis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wangyulong
 * @datetime: 2019-07-08 11:44
 * @param: 
 * @return: 
 * @description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int item:result) {
            System.out.println(item);
        }

    }

    /**
     * @author: wangyulong
     * @datetime: 2019-07-09 09:57
     * @param: [nums, target]
     * @return:
     * @description: 方法一
     */
    public static int[] twoSum(int[] nums, int target) {
        String str = "-";
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    if (!str.contains("-" + i + "-")) {
                        str += i + "-";
                    }
                    if (!str.contains("-" + j + "-")) {
                        str += j + "-";
                    }
                }
            }
        }
        String[] strArr = str.split("-");
        int[] result = new int[strArr.length > 1 ? (strArr.length - 1) : 0];
        for (int i = 1; i < strArr.length; i++) {
            result[i - 1] = Integer.parseInt(strArr[i]);
        }
        return result;
    }

    /**
     * @author: wangyulong
     * @datetime: 2019-07-09 09:57
     * @param: [nums, target]
     * @return:
     * @description: 方法二
     */
    public static int[] twoSumTwo(int[] nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    set.add(i);
                    set.add(j);
                }
            }
        }
        int result[] = new int[set.size()];
        int temp = 0;
        for (Integer index:set) {
            result[temp] = index;
            temp += 1;
        }
        return result;
    }

    /**
     * @author: wangyulong
     * @datetime: 2019-07-09 09:57
     * @param: [nums, target]
     * @return:
     * @description: 方法三
     */
    public static int[] twoSumThree(int[] nums, int target) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    if (!list.contains(i)) {
                        list.add(i);
                    }
                    if (!list.contains(j)) {
                        list.add(j);
                    }
                }
            }
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).intValue();
        }
        return result;
    }
}
