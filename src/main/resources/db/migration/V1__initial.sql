-- Discord Tables starts with d_
CREATE TABLE d_guild (
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    discord_id varchar UNIQUE,
    name varchar,
    region varchar,
    PRIMARY KEY (id)
);

CREATE TABLE d_member (
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    discord_id varchar UNIQUE,
    username varchar,
    discriminator int,
    PRIMARY KEY (id)
);

CREATE TABLE d_guild_d_member(
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    d_guild_id uuid,
    d_member_id uuid,
    FOREIGN KEY (d_guild_id) REFERENCES d_guild(id),
    FOREIGN KEY (d_member_id) REFERENCES d_member(id),
    PRIMARY KEY (id)
);

CREATE TABLE d_roles(
    id uuid,
    version int,
    name varchar,
    PRIMARY KEY (id)
);

CREATE TABLE d_member_roles(
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    d_member_id uuid,
    d_roles_id uuid,
    FOREIGN KEY (d_member_id) REFERENCES d_member(id),
    FOREIGN KEY (d_roles_id) REFERENCES d_roles(id),
    PRIMARY KEY (id)
);

INSERT INTO public.d_roles("id", "version", "name") VALUES
('6e4cde2e-1b51-41c8-9b98-e65a081b0cf0',1,'owner'),
('ac7e7d24-2918-4266-8f75-15b9d3cc57c7',1,'admin'),
('f63b720d-e6f3-487f-b878-593c3a8a9a31',1,'recruiter');

-- Albion tables starts with a_
CREATE TABLE a_guild(
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    name varchar,
    founder_name varchar,
    founder_id varchar,
    founded_at bigint,
    killfame bigint,
    deathfame bigint,
    PRIMARY KEY (id)
);

-- Table to join a guild from albion with a discord server

CREATE TABLE d_guild_a_guild (
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    d_guild_id uuid,
    a_guild_id uuid,
    FOREIGN KEY (d_guild_id) REFERENCES d_guild(id),
    FOREIGN KEY (a_guild_id) REFERENCES a_guild(id),
    PRIMARY KEY (id)
);

CREATE TABLE a_member(
    id uuid,
    version int,
    a_guild_id uuid,
    avg_ip int,
    name varchar,
    in_game_id varchar,
    ally_name varchar,
    ally_id varchar,
    ally_tag varchar,
    avatar varchar,
    avatar_ring varchar,
    death_fame int,
    kill_fame int,
    fame_ratio float,
    pve_total int,
    gathering_fiber int,
    gathering_hide int,
    gathering_ore int,
    gathering_rock int,
    gathering_wood int,
    crafting_total int,
    time_stemp varchar,
    PRIMARY KEY(id),
    FOREIGN KEY (a_guild_id)  REFERENCES  a_guild(id)
);

CREATE TABLE a_member_log(
    id uuid,
    version int,
    created_at bigint,
    updated_at bigint,
    player_name varchar,
    player_id varchar,
    pve_total bigint,
    gathering_total bigint,
    crafting_total bigint,
    guild_name varchar,
    guild_id varchar,
    PRIMARY KEY (id)
);