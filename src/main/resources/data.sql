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
-- menu
INSERT INTO MENU(id,DESCRIPTION,ICON,NAME,URL,ISADMIN)
VALUES (1, 'Menu expense','expense','Expense','home.expense',false);


INSERT INTO MENU(id, DESCRIPTION,ICON,NAME,URL,ISADMIN)
VALUES (2, 'Setting manager','setting','Setting','',false);

INSERT INTO SUBMENU (DESCRIPTION, ICON, NAME ,URL,MENU_ID)
VALUES ('Setting','setting', 'setting','home.setting', false);

INSERT INTO MENU(id, DESCRIPTION,ICON,NAME,URL,ISADMIN)
VALUES (3,'Admin Manger','admin','Admin','home.admin',true);
