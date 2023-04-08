public interface Graph<V, E> {

    /**
     * @return 边个数
     */
    int edgesSize();

    /**
     * @return 顶点个数
     */
    int verticesSize();

    /**
     * 添加顶点
     * @param v 顶点元素
     */
    void addVertex(V v);

    /**
     * 添加边
     * @param from 来自哪个顶点
     * @param to 到哪个顶点
     */
    void addEdge(V from, V to);

    /**
     * 添加边
     * @param from 来自哪个顶点
     * @param to 到哪个顶点
     * @param weight 边权重
     */
    void addEdge(V from, V to, E weight);

    /**
     * 移除顶点
     * @param v 顶点元素
     */
    void removeVertex(V v);

    /**
     * 移除边
     * @param from 来自哪个顶点
     * @param to 到哪个顶点
     */
    void removeEdge(V from, V to);

}
