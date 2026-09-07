import java.util.*;

class Solution {
    
    class Node {
        String name;
        List<Node> next;
        List<Integer> ticketIds; // 몇 번째 항공권(ticket index)인지 기록
        
        public Node(String name){
            this.name = name;
            this.next = new ArrayList<>();
            this.ticketIds = new ArrayList<>();
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        // 각 나라 노드들 리스트 - 나중에 name으로 각 Node를 쉽게 꺼내기 위함
        Map<String, Node> map = new HashMap<>();
        
        for(String[] ticket : tickets){
            
            String name1 = ticket[0];
            String name2 = ticket[1];
            
            // 기존 리스트에 없으면, 넣음
            if(!map.containsKey(name1)){
                map.put(name1, new Node(name1));
            }
            
            if(!map.containsKey(name2)){
                map.put(name2, new Node(name2));
            }
        }
        
        // 간선 연결하기
        for (int i = 0; i < tickets.length; i++) {
            Node startNode = map.get(tickets[i][0]);
            Node endNode = map.get(tickets[i][1]);

            startNode.next.add(endNode);
            startNode.ticketIds.add(i); // i번째 티켓임을 저장
        }
        
        // 각 노드에 대해서 next 정렬하기
        for (Node node : map.values()) {
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < node.next.size(); i++) {
                indices.add(i);
            }

            // 목적지 이름 기준 정렬
            indices.sort((a, b) -> node.next.get(a).name.compareTo(node.next.get(b).name));

            List<Node> sortedNext = new ArrayList<>();
            List<Integer> sortedTicketIds = new ArrayList<>();
            
            for (int idx : indices) {
                sortedNext.add(node.next.get(idx));
                sortedTicketIds.add(node.ticketIds.get(idx));
            }
            
            node.next = sortedNext;
            node.ticketIds = sortedTicketIds;
        }
        
        Stack<Object[]> stack = new Stack<>();
        boolean[] isVisited = new boolean[tickets.length];
        
        // 경로 기록용
        List<String> path = new ArrayList<>();
        List<Integer> usedTickets = new ArrayList<>();
        
        Map<Node, Integer> nextCheckIdx = new HashMap<>();
        for (Node n : map.values()) nextCheckIdx.put(n, 0);
        
        Node start = map.get("ICN");
        stack.push(new Object[]{start, 0});
        path.add(start.name);
        
        while(!stack.isEmpty()){
            
            // 모든 항공권을 다 사용했으면 완료
            if (usedTickets.size() == tickets.length) {
                break;
            }
            
            Object[] top = stack.peek();
            Node current = (Node) top[0];
            int startIdx = (Integer) top[1];
            
            boolean moved = false;
            
            for (int i = startIdx; i < current.next.size(); i++) {
                int ticketId = current.ticketIds.get(i);

                // 현재 스택 프레임의 다음에 검사할 인덱스를 미리 업데이트
                top[1] = i + 1;

                if (!isVisited[ticketId]) {
                    isVisited[ticketId] = true;
                    usedTickets.add(ticketId);

                    Node nextNode = current.next.get(i);
                    stack.push(new Object[]{nextNode, 0});
                    path.add(nextNode.name);
                    
                    moved = true;
                    break;
                }
            }
            
            // 막다른 길에 도달했을 때
            if (!moved && usedTickets.size() != tickets.length) {
                stack.pop();
                path.remove(path.size() - 1);

                // 직전에 사용했던 티켓 원상복구
                int lastTicket = usedTickets.remove(usedTickets.size() - 1);
                isVisited[lastTicket] = false;
                
            }
        }
        
        return path.toArray(new String[0]);
    }
}