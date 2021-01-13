package com.sandipan.work.dashboard.dao;

import com.sandipan.work.dashboard.model.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, BigInteger> {


}
