package cn.zut.edu.logcol.logcollecttion.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocSim {
    String tol;
    String sim;
    /**
     * @return the tol
     */
    public String getTol() {
        return tol;
    }
    public LocSim(String sim,String tol){
        this.tol=tol;
        this.sim=sim;
    }
}
