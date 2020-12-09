package sample.Model;

public class BullsAndCows {

        private String bAndc;

        public BullsAndCows() {
            this.bAndc = "";
            int j = 0;
            boolean[] var = new boolean[10];
            int j_0 = (int) (Math.random() * 9 + 1);
            this.bAndc += j_0;
            var[j_0] = true;

            for (int i = 0; this.bAndc.length() < 4; i++) {
                j = (int) (Math.random() * 10);
                if (!var[j]) {
                    this.bAndc += j;
                    var[j] = true;
                }
            }
        }

        public BullsAndCows(String string) {
            this.bAndc = string;
        }

        public BullsAndCows(Integer integer) {
            this.bAndc = integer.toString();
        }

        public String getBullsAndCows() {
            return this.bAndc;
        }

        public int hmB(BullsAndCows bAndc_internal) {
            int bulls = 0;
            for (int i = 0; i < 4; i++) {
                if (this.bAndc.charAt(i) == bAndc_internal.getBullsAndCows().charAt(i))
                    bulls++;
            }
            return bulls;
        }

        public int hmC(BullsAndCows bAndc_internal) {
            int cows = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (this.bAndc.charAt(i) == bAndc_internal.getBullsAndCows().charAt(j) && i != j)
                        cows++;
                }
            }
            return cows;
        }

        public String toString(BullsAndCows bAndc_internal){
            return hmB(bAndc_internal)+"B, "+hmC(bAndc_internal) + "K";
        }

    }