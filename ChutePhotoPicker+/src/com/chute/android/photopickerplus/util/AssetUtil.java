package com.chute.android.photopickerplus.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.net.Uri;

import com.chute.android.photopickerplus.models.DeliverMediaModel;
import com.chute.sdk.v2.model.AccountAlbumModel;
import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.AccountMediaModel;
import com.chute.sdk.v2.model.AssetModel;

public class AssetUtil {

	public static ArrayList<AssetModel> getPhotoCollection(
			List<DeliverMediaModel> resultList) {
		final ArrayList<AssetModel> collection = new ArrayList<AssetModel>();
		for (DeliverMediaModel result : resultList) {
			AssetModel asset = getMediaModel(result);
			collection.add(asset);
		}
		return collection;
	}

	public static AssetModel getMediaModel(DeliverMediaModel model) {
		final AssetModel asset = new AssetModel();
		asset.setThumbnail(Uri.fromFile(new File(model.getThumbnail()))
				.toString());
		asset.setUrl(model.getImageUrl());
		asset.setVideoUrl(model.getVideoUrl());
		asset.setType(model.getMediaType().name().toLowerCase());
		return asset;
	}

	public static AccountBaseModel filterFiles(
			AccountBaseModel accountBaseModel, boolean supportImages,
			boolean supportVideos) {
		AccountBaseModel model = new AccountBaseModel();
		List<AccountAlbumModel> folders = accountBaseModel.getFolders();
		List<AccountMediaModel> files = new ArrayList<AccountMediaModel>();
		List<AccountMediaModel> videos = new ArrayList<AccountMediaModel>();
		List<AccountMediaModel> images = new ArrayList<AccountMediaModel>();
		if (accountBaseModel.getFiles() != null) {
			for (AccountMediaModel file : accountBaseModel.getFiles()) {
				if (file.getVideoUrl() != null && supportVideos == true) {
					videos.add(file);
				}
				if (file.getVideoUrl() == null && supportImages == true) {
					images.add(file);
				}
			}
		}
		files.addAll(images);
		files.addAll(videos);
		model.setFiles(files);
		model.setFolders(folders);
		return model;
	}

}
