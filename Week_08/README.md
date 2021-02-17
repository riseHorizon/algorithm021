#位运算

##1.位运算符

###如何从十进制转换为二进制

https://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6

####1.1.左移 << 0011 => 0110

####1.2.右移 >> 0110 => 0011

####1.3.按位或     | 0011 1011 => 1011

####1.4.按位与     & 0011 1011 => 0011

####1.5.按位取反   ~  0011     => 1100

####1.6.按位异或（相同为0不同为1）^  0011 1011 => 1000

##2.算数移位与逻辑移位

###指定位置的位运算

####1.将x最右边的n位清零：x&(~0<<n)

####2.获取x的第n位值（0或者1）：(x>>n)&1

####3.获取x的第n位的幂值：x&(1<<n)

####4.仅将第n位置为1：x|(1<<n)

####5.仅将第n位置为0：x&(~(1<<n))

####6.将最高位至第n位（含）清零：x&((1<<n)-1)

###实战位运算要点：
####判断奇偶：

x%2 == 1 ---> (x & 1) == 1

x%2 == 0 ---> (x & 1) == 0

x>>1 ---> x/2

即：x = x/2; ---> x = x>>1;

mid = (left + right)/2; ---> mid = (left + right) >> 1;

x = x&(x - 1) 清零最低位的1

x&-x => 得到最低位的1

x&~x => 0

##3.位运算的应用

###八皇后位运算代码：

###Java

class Solution {

    private int size;
    private int count;

	private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p; // pos &= pos - 1;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

	public int totalNQueens(int n) {
		count = 0;
		size = (1 << n) - 1;
		solve(0, 0, 0);
		return count;
    }
}

###1.余数短除法除以二

###2.降二次幂及减法混合运算

#十大经典算法：

https://www.cnblogs.com/onepixel/p/7674659.html

##一.比较排序：

1.交换排序：冒泡，快排

2.插入排序:直接插入，希尔

3.归并排序：二路归并排序，多路归并排序

4.选择排序:直接选择排序，堆排序

##二.非比较排序：
计数排序，桶排序，基数排序
