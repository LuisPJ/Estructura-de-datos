class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); //Asigna el valor char especificado a cada elemento del intervalo especificado de la matriz de caracteres especificada.
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                j++;
            }
        }

        return dp[n];
    }
}