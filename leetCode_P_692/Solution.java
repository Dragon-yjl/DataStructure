package leetCode_P_692;


import leetCode.LinkedCopy;

import java.util.*;

public class Solution {
    //把出现的单词和次数包装成一个类
    public static class WordAndCount implements Comparable<WordAndCount>{
        String word;
        int count;

        public WordAndCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "WordAndCount{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }

        @Override
        public int compareTo(WordAndCount o) {
            //this  和  o 比较
            if(count > o.count) {
                return -1;//表示this在前，小的在前
            }else if(count < o.count) {
                return 1;
            }else {//否则按照字母顺序比
                return word.compareTo(o.word);
            }
        }
    }

    ///统计前 K个单词出现频率最高的
    public List<String> topKFrequent(String[] words, int k) {
        //吧每个单词出现的的次数插入到 map中
        //everyTWordTime 表示统计每个单词出现的次数
        Map<String,Integer> map = everyWordTime(words);

        int index = 0;
        WordAndCount[] array = new WordAndCount[map.size()];
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            WordAndCount wc = new WordAndCount(word,count);
            array[index++] = wc;

        }

        //到这WordAndCount数组中已经有了单词和它出现的次数

        //对WordAndCount数组进行排序
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        //装到list中
        List<String> res = new ArrayList<>();
        for(int i = 0;i <= k;i++) {
            res.add(array[i].word);///只把单词放进去
        }

        return res;
    }

    //统计每个单词出现的次数
    private Map<String, Integer> everyWordTime(String[] words) {
        Map<String,Integer> map = new TreeMap<>();
        for(String word : words) {
            int count = map.getOrDefault(word,0);
            count++;
            map.put(word,count);
        }

        //map表示出现次数
        return map;

    }

}
