package org.example.projectspringfalling.userSubscription;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
import org.example.projectspringfalling._core.utils.DateCalcUtil;
import org.example.projectspringfalling._core.utils.DateUtil;

import static org.example.projectspringfalling._core.utils.DateUtil.timestampToString;

public class UserSubscriptionResponse {

    @Data
    public static class UserSubscriptionDTO {
        private List<AvailableSubDTO> availableSubscriptions;
        private List<EndSubDTO> endedSubscriptions;

        public UserSubscriptionDTO(List<AvailableSubDTO> availableSubscriptions, List<EndSubDTO> endedSubscriptions) {
            this.availableSubscriptions = availableSubscriptions;
            this.endedSubscriptions = endedSubscriptions;
        }

        @Data
        public static class AvailableSubDTO {
            private Integer id;
            private Integer subscriptionId;
            private Integer userId;
            private String subscriptionName;
            private String startDate;
            private String endDate;
            private String userSubscriptionState;
            private Integer duration;
            private String transactionId;

            public AvailableSubDTO(UserSubscription userSubscription) {
                this.id = userSubscription.getId();
                this.subscriptionId = userSubscription.getSubscription().getId();
                this.userId = userSubscription.getUser().getId();
                this.subscriptionName = userSubscription.getSubscription().getName();
                this.startDate = timestampToString(userSubscription.getStartDate());
                this.duration = (userSubscription.getSubscription().getDuration());
                this.userSubscriptionState = userSubscription.getStatus();
                this.endDate = timestampToString(DateCalcUtil.calculateEndDate(userSubscription.getStartDate(), this.duration));
            }
        }

        @Data
        public static class EndSubDTO {
            private Integer id;
            private Integer subscriptionId;
            private Integer userId;
            private String subscriptionName;
            private String startDate;
            private String endDate;
            private String userSubscriptionState;
            private Integer duration;

            public EndSubDTO(UserSubscription userSubscription) {
                this.id = userSubscription.getId();
                this.subscriptionId = userSubscription.getSubscription().getId();
                this.userId = userSubscription.getUser().getId();
                this.subscriptionName = userSubscription.getSubscription().getName();
                this.startDate = timestampToString(userSubscription.getStartDate());
                this.duration = (userSubscription.getSubscription().getDuration());
                this.userSubscriptionState = userSubscription.getStatus();
                this.endDate = timestampToString(DateCalcUtil.calculateEndDate(userSubscription.getStartDate(), this.duration));
            }
        }
    }
}
