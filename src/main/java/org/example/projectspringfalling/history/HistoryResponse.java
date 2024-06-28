package org.example.projectspringfalling.history;

import lombok.Data;

public class HistoryResponse {

    @Data
    public static class SaveDTO{
        private Integer songId;
        private Integer userId;

        public SaveDTO(History history) {
            this.songId = history.getSong().getId();
            this.userId = history.getUser().getId();
        }
    }
}
