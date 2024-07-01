package org.example.projectspringfalling.report;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    // 관리자 신고 리스트
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$ReportedList(r.id, rp.content, r.content, r.createdAt, r.status) FROM Report r JOIN r.reply rp ORDER BY r.createdAt DESC ")
    List<AdminResponse.ReportedList> findAllReportedList();
}
