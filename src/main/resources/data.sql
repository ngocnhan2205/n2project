/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');

INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');


/* Populate APP_USER Table */
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES ('admin','$2a$10$hLkfaVeSZ9UB7hCrE1eeheb7EacOr9xbbghmkc0mqmdrPN.9dY.Fa', 'Nhan','Dinh','huunhancit@gmail.com', 'Active');

/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='admin' and profile.type='ADMIN';
--   user
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES ('user','$2a$10$hLkfaVeSZ9UB7hCrE1eeheb7EacOr9xbbghmkc0mqmdrPN.9dY.Fa', 'Ngoc','Bich','bbngoc@gmail.com', 'Active');

/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='user' and profile.type='USER';
-- menu
INSERT INTO MENU(id, DESCRIPTION, ICON, NAME, URL, ISADMIN, OTHERINDEX)
VALUES (1, 'Dashboard','dashboard','Dashboard','home.dashboard',false, 1);

INSERT INTO MENU(id, DESCRIPTION, ICON, NAME, URL, ISADMIN, OTHERINDEX)
VALUES (2, 'Expense','expense','Expense','home.expense',false, 2);

INSERT INTO MENU(id, DESCRIPTION, ICON, NAME, URL, ISADMIN, OTHERINDEX)
VALUES (3, 'Report','report','Report','home.report',false, 3);

INSERT INTO MENU(id, DESCRIPTION, ICON, NAME, URL, ISADMIN, OTHERINDEX)
VALUES (4, 'Administrator','admin','Administrator','home.administrator',true, 4);