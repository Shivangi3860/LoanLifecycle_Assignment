    package com.LoanLifecycle.LoanLifecycle.Entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "kyc_docs")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class KycEntity {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getAdhar_front() {
            return adhar_front;
        }

        public void setAdhar_front(String adhar_front) {
            this.adhar_front = adhar_front;
        }

        public String getAdhar_back() {
            return adhar_back;
        }

        public void setAdhar_back(String adhar_back) {
            this.adhar_back = adhar_back;
        }

        public String getPan() {
            return pan;
        }

        public void setPan(String pan) {
            this.pan = pan;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;


        @Column
        private String adhar_front;
        @Column
        private String adhar_back;
        @Column
        private String pan;
        @Column
        private int customerId;


    }


