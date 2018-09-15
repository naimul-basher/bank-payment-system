package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.ChannelMap;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelMap, String> {

	public ChannelMap findBychannelID(String channelID);
}