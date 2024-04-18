class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String start = "0000";

        if (deadendSet.contains(start) || deadendSet.contains(target)) {
            return -1;
        }
        
        queue.offer(start); //.OFFER inserta el elemento especificado en esta cola
        visited.add(start);
        int turns = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll(); //.POLL le permite recuperar y eliminar el elemento superior (cabeza) de una cola.
                if (current.equals(target)) {
                    return turns;
                }
                List<String> neighbors = getNeighbors(current);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor) && !deadendSet.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
    
        private List<String> getNeighbors(String code) {
        List<String> neighbors = new ArrayList<>();
        char[] digits = code.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            char original = digits[i];
            // Incrementar el dígito
            digits[i] = (char) ((digits[i] - '0' + 1) % 10 + '0');
            neighbors.add(new String(digits));
            // Decrementar el dígito
            digits[i] = (char) ((original - '0' + 9) % 10 + '0');
            neighbors.add(new String(digits));
            // Restaurar el dígito original
            digits[i] = original;
        }
        return neighbors;
    }
        
    
}