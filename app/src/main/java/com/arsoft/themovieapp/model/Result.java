package com.arsoft.themovieapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {



    // @SerializedName: Maps the "page" field from the JSON response to the Java variable "pageNumber"
    // If the JSON key and the Java variable name are the same, using @SerializedName is optional.
    // @Expose: Indicates that this field should be exposed for JSON serialization and deserialization by Gson
    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    @SerializedName("total_results")
    @Expose
    private Integer totalResult;

    @SerializedName("results")
    @Expose
    private List<Movie> result = null;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public List<Movie> getResult() {
        return result;
    }

    public void setResult(List<Movie> result) {
        this.result = result;
    }

    public Result() {
    }
}
