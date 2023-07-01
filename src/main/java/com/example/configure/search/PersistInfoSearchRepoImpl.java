package com.example.configure.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;

import co.elastic.clients.elasticsearch.core.BulkResponse;
import com.example.configure.Model.PersistInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersistInfoSearchRepoImpl {
    private final ElasticsearchClient esClient;
    private static final String INDEX = "persist-info";

    public BulkResponse saveAll(List<PersistInfo> persistInfoList) throws IOException {
        try{
            BulkRequest.Builder br = new BulkRequest.Builder();

            for (PersistInfo persistInfo : persistInfoList) {
                br.operations(op -> op
                        .index(idx -> idx
                                .index(INDEX)
                                .id(persistInfo.getEmailId())
                                .document(persistInfo)
                        )
                );
            }

            return esClient.bulk(br.build());
        } catch (IOException e){
            System.out.printf("error" + e);
            throw e;
        }
    }
}
