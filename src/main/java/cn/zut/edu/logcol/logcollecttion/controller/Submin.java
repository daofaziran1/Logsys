package cn.zut.edu.logcol.logcollecttion.controller;
import cn.zut.edu.logcol.logcollecttion.bean.LocationOneDay;
import cn.zut.edu.logcol.logcollecttion.bean.TotalOneDay;
import cn.zut.edu.logcol.logcollecttion.service.LocService;
import cn.zut.edu.logcol.logcollecttion.service.LocSimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/")
@Controller
public class Submin {
    @Autowired
    private LocService locService;
    @Autowired
    private LocSimService locSimService;
    @RequestMapping(value = "/submit",method = RequestMethod.GET)
    public String submit(@RequestParam("startTime") String a, @RequestParam("endTime") String b, Model model){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println("zheshi");
            Date date1=df.parse(a);
            Date date2=df.parse(b);
            String st=Long.toString(date1.getTime()/(3600000*24) +1);
            String ed=Long.toString(date2.getTime()/(3600000*24) +1);
           //TotalOneDay tod=this.query(st,ed);
            TotalOneDay tod=this.query(st,ed);
            
            model.addAttribute("locations",tod.getLocationOneDays());
            model.addAttribute("tol",tod.getSum());
        } catch (ParseException  e) {
            e.printStackTrace();
        }
        return "showinfo.html";
    }
    public TotalOneDay query(String st,String ed){
        List<TotalOneDay> totalOneDayList=locService.query(st,ed);
        HashMap<String,Long> hs=new HashMap<>();
        HashMap<String,String> hss=new HashMap<>();
        for(TotalOneDay tod:totalOneDayList){
            for(LocationOneDay loc:tod.getLocationOneDays()){
                String sim=loc.getLocation();
                String tol=null;
                if(hss.containsKey(sim)){
                    tol=hss.get(sim);
                }else{
                    tol=locSimService.getloc(sim).getTol();
                    hss.put(sim,tol);
                }
                if(!hs.containsKey(tol)){
                    hs.put(tol,loc.getNum());
                }else{
                    hs.put(tol,hs.get(tol)+loc.getNum());
                }
            }
        }
        TotalOneDay todd=new TotalOneDay(hs,new Date());
        return todd;
    }

}
