import java.util.*;

/**
 * Created by luoluyao on 2017/11/10.
 */
public class Knn {
    private int k;
    public Knn(int k) {
        this.k = k;
    }
    private Comparator<KnnNodes> comparator = new Comparator<KnnNodes>() {
        @Override
        public int compare(KnnNodes o1, KnnNodes o2) {
            if (o1.getDis() >= o2.getDis()) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    String knn(List<KnnNodes> list, Node node) {
        PriorityQueue<KnnNodes> priorityQueue = new PriorityQueue<KnnNodes>(5, comparator);
        for (KnnNodes knnNodes : list) {
            priorityQueue.add(knnNodes);
        }
        return getLabel(priorityQueue);
    }

    private String getLabel(Queue<KnnNodes> queue) {
        int maxCount = 0;
        HashMap<KnnNodes, Integer> hashMap = new HashMap<KnnNodes, Integer>();
        KnnNodes knnNodesRes = null;
        int k = this.k;
        while (k-- != 0) {
            KnnNodes knnNodes = queue.poll();
            // System.out.println(knnNodes.getX() + " " + knnNodes.getY() + " " + knnNodes.getDis() + " " + knnNodes.getLabel());
            if (hashMap.containsKey(knnNodes)) {
                hashMap.put(knnNodes, hashMap.get(knnNodes) + 1);
            } else {
                hashMap.put(knnNodes, 1);
            }
            if (maxCount <= hashMap.get(knnNodes)) {
                maxCount = hashMap.get(knnNodes);
                knnNodesRes = knnNodes;
            }
        }
        return knnNodesRes == null ? "" : knnNodesRes.getLabel();
    }
}
