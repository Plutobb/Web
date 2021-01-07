public class List {
    //建立一个Node的类
    static class Node {
        public int data;
        public Node next;//存储对象引用

        //构造方法
        public Node(int data) {
            this.data = data;
            //这里没有初始化next的引用是，不知道next当前指向那个节点
        }
    }
    public static class SingleList {
        public Node head;//作用是定位头节点的引用

        //头插法
        public void addFirst(int data){
            Node node = new Node(data);
            //链表中没有元素时
            if(this.head == null){
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }
        //尾插法
        public void addLast(int data){
            Node node = new Node(data);
            //链表中没有元素时
            if(this.head == null){
                this.head = node;
            } else {
                Node cur = this.head;
                while(cur.next != null){
                    cur = cur.next;
                }
                if(cur.next == null){
                    cur.next = node;
                }
            }
        }

        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index,int data) {
            Node cur = this.head;
            Node node = new Node(data);
            int count = 0;
            if(index > size() || index < 0){
                System.out.println("插入位置不合法");
                return;
            }
            if(index == 0){
                addFirst(data);
                return;
            } else {
                while(count < index - 1){
                    cur = cur.next;
                    count++;
                }
                node.next = cur.next;
                cur.next = node;
            }

        }
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key) {
            Node cur = this.head;
            while(cur != null){
                if(cur.data == key){
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
        //删除第一次出现关键字为key的节点
        public void remove(int key){
            if(contains(key)){
                Node cur = this.head;
                //删头
                if(this.head.data == key){
                    this.head = cur.next;
                    return;
                }
                // 删中间和尾
                while(cur != null){
                    if(cur.next.data == key){
                        cur.next = cur.next.next;
                        return;
                    }
                    cur = cur.next;
                }
            } else {
                System.out.println("该链表内没有key值 删除错误");
                return;
            }
        }
        //删除所有值为key的节点
        public void removeAllKey(int key) {
            boolean flg = true;
            while(contains(key)){
                remove(key);
                flg = false;
            }
            if(flg){
                System.out.println("该链表内没有key值 删除错误");
            }
        }
        //得到单链表的长度
        public int size() {
            Node cur = this.head;
            int count = 0;
            while(cur != null){
                count++;
                cur = cur.next;
            }
            return count;
        }
        public void display() {
            if(this.head == null){
                System.out.print("此时链表为空");
            }
            Node cur = this.head;
            while(cur != null){
                System.out .print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }

        public static void main (String[] args){

        }
    }


}
