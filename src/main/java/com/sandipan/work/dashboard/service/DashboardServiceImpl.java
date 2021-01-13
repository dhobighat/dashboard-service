package com.sandipan.work.dashboard.service;

import com.sandipan.work.dashboard.dao.DashboardRepository;
import com.sandipan.work.dashboard.model.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DashboardServiceImpl {


    @Autowired
    DashboardRepository dashboardRepository;

    public String getReleaseNotes(){
       List<Dashboard> dashboard = (List<Dashboard>) dashboardRepository.findAll();
       return dashboard.get(0).getVersion()+":"+dashboard.get(0).getReleaseNotes();
    }
}
