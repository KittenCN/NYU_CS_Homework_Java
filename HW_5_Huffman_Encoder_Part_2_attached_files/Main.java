package HW_5_Huffman_Encoder_Part_2_attached_files;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lg = sc.nextLine();
        BinaryHeap hp = HuffmanTree.legendToHeap(lg);
        HuffmanTree nd = HuffmanTree.createFromHeap(hp);
        nd.printLegend();
        sc.close();
    }
}
