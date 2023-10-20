package com.LoanLifecycle.LoanLifecycle.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appraisal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class appraisalEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "jewel_name")
    private String jewelName;

    @Column(name="jewel_net_wt")
    private String jewelNetWt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJewelName() {
        return jewelName;
    }

    public void setJewelName(String jewelName) {
        this.jewelName = jewelName;
    }

    public String getJewelNetWt() {
        return jewelNetWt;
    }

    public void setJewelNetWt(String jewelNetWt) {
        this.jewelNetWt = jewelNetWt;
    }


}
