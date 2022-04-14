package HW_4_Huffman_Encoder_attached_files;

public class HuffmanTree {
    HuffmanNode root;
    public HuffmanTree(HuffmanNode huff) {
        this.root = huff;
    }
 
    public void printLegend() {
        printLegend(root, "");
    }
 
    private void printLegend(HuffmanNode t, String s) {
        if (t.letter.length() > 1) {
            printLegend(t.left, s + "0");
            printLegend(t.right, s + "1");
        }
        if (t.letter.length() == 1) {
            System.out.println(t.letter + "=" + s);
        }
    }
 
    public static BinaryHeap legendToHeap(String legend) {
        BinaryHeap bheap = new BinaryHeap();
        String[] ele = legend.split(" ");
        for (int i = 0; i < ele.length; i += 2) {
            String letter = ele[i];
            Double freq = Double.parseDouble(ele[i + 1]);
            bheap.insert(new HuffmanNode(letter, freq));
        }
        return bheap;
    }
 
    public static HuffmanTree createFromHeap(BinaryHeap b) {
        while (b.getSize() != 1) {
            HuffmanNode n1 = (HuffmanNode)b.deleteMin();
            HuffmanNode n2 = (HuffmanNode)b.deleteMin();
            HuffmanNode merged = new HuffmanNode(n1, n2);
            merged.left=n1;
            merged.right=n2;
            b.insert(merged);
        }
        HuffmanTree tree = new HuffmanTree((HuffmanNode)b.findMin());
        return tree;
    }
}
