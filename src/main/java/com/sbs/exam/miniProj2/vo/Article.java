package com.sbs.exam.miniProj2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Article {
        private int id;
        private String title;
        private String body;

    }
