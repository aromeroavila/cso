package com.arao.cheapsoapopera.profile;

import com.arao.cso.data.profile.ProfileRepository;

public class ProfilePresenter {

    private final ProfileRepository profileRepository;

    private ProfileView profileView;

    ProfilePresenter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    void initialise(ProfileView profileView) {
        this.profileView = profileView;
    }

    void onCreateNewProilePressed() {

    }

    void onChangeProfileNamePresed() {

    }

}
