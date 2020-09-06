package com.wfp.slide.slide;


public interface OnRefreshListener {

	/**
	 * 下拉刷新回调接口
	 */
	void onPullRefresh();

	/**
	 * 上拉加载更多接口
	 */
	void onPushLoadMore();

}
