package com.ghstudio.pairprogram.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * IndexGenerate 索引生成 util
 */
public class IndexGenerate {
    private static final Random random = new Random();

    /**
     * generateIndex 根据不同 role 获取不同范围的索引
     *
     * @param count 属灵
     * @param role  学习
     * @return 索引列表
     */
    public static List<Integer> generateIndex(Integer count, Integer role) {
        List<Integer> result = new ArrayList<>();
        int baseRole = (role - 1) * 200;
        for (int i = 0; i < count; ) {
            Integer tmp = random.nextInt(200) + 1 + baseRole;
            if (!result.contains(tmp)) {
                result.add(tmp);
                i++;
            }
        }

        return result;
    }
}
