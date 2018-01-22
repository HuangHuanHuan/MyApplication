package com.example.administrator.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/1/18.
 */

public class VideoBean {

    /**
     * data : {"thumbnail":"","swfurl":"http://dispatcher.video.qiyi.com/disp/shareplayer.swf?vid=7049f905e86acb4ed725fb170fec1689&tvId=7936953909&cnId=23&coop=ugc_openapi_recommendapp&cid=qc_100001_300089&bd=1&autoChainPlay=0&autoplay=1&showRecommend=0","urllist":{"mp4":{"2":"http://data.video.qiyi.com/videos/v1/20170519/64/a6/7e9182cb409f51c694bc2a0e5f5a17ba.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501041&qd_ip=751952af&qd_p=751952af&qd_sc=5beba51eced2df941602111fb387da0c&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1","1":"http://data.video.qiyi.com/videos/v1/20170519/64/a6/bc7ae488e7aa8327ddd06d0d52090efa.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501042&qd_ip=751952af&qd_p=751952af&qd_sc=a3807d14a211687cf5e9cfa5b13e0e39&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1"},"m3u8":{"2":"http://cache.m.iqiyi.com/mus/7936953909/08d2b502c23dba8082fec1203e6d9317/afbe8fd3d73448c9//20170519/64/a6/f75dfb9d5f52bf7af50e87b4780cebb0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=0b0067360c163f965039606b95d66fff&qypid=7936953909_04000000001000000000_2&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=c2d5101647c56c4a2afd0579124d429e&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893","1":"http://cache.m.iqiyi.com/mus/7936953909/34041a82c50a5272a61df5c7801c714a/afbe8fd3d73448c9//20170519/d0/36/e03f31a4ef80f71354ea0499ec9bdc7d.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=582de94c39458a5a5a8b34d9b7628c49&qypid=7936953909_04000000001000000000_1&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=a19e29797bedf2ed203f3d512a3e501a&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893","96":"http://cache.m.iqiyi.com/mus/7936953909/7049f905e86acb4ed725fb170fec1689/afbe8fd3d73448c9//20170519/2e/32/4352dc42ef4417408d124e27a943f2e0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=4c74e480cdeb49b1c14f4d872d839d32&qypid=7936953909_04000000001000000000_96&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=6815186121e5b23599891a6e87ecb5bf&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893"}},"img":"http://u8.qiyipic.com/image/20170519/ca/98/uv_2040033745_m_601.jpg"}
     * code : A00000
     */

    private DataBean data;
    private String code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * thumbnail :
         * swfurl : http://dispatcher.video.qiyi.com/disp/shareplayer.swf?vid=7049f905e86acb4ed725fb170fec1689&tvId=7936953909&cnId=23&coop=ugc_openapi_recommendapp&cid=qc_100001_300089&bd=1&autoChainPlay=0&autoplay=1&showRecommend=0
         * urllist : {"mp4":{"2":"http://data.video.qiyi.com/videos/v1/20170519/64/a6/7e9182cb409f51c694bc2a0e5f5a17ba.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501041&qd_ip=751952af&qd_p=751952af&qd_sc=5beba51eced2df941602111fb387da0c&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1","1":"http://data.video.qiyi.com/videos/v1/20170519/64/a6/bc7ae488e7aa8327ddd06d0d52090efa.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501042&qd_ip=751952af&qd_p=751952af&qd_sc=a3807d14a211687cf5e9cfa5b13e0e39&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1"},"m3u8":{"2":"http://cache.m.iqiyi.com/mus/7936953909/08d2b502c23dba8082fec1203e6d9317/afbe8fd3d73448c9//20170519/64/a6/f75dfb9d5f52bf7af50e87b4780cebb0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=0b0067360c163f965039606b95d66fff&qypid=7936953909_04000000001000000000_2&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=c2d5101647c56c4a2afd0579124d429e&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893","1":"http://cache.m.iqiyi.com/mus/7936953909/34041a82c50a5272a61df5c7801c714a/afbe8fd3d73448c9//20170519/d0/36/e03f31a4ef80f71354ea0499ec9bdc7d.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=582de94c39458a5a5a8b34d9b7628c49&qypid=7936953909_04000000001000000000_1&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=a19e29797bedf2ed203f3d512a3e501a&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893","96":"http://cache.m.iqiyi.com/mus/7936953909/7049f905e86acb4ed725fb170fec1689/afbe8fd3d73448c9//20170519/2e/32/4352dc42ef4417408d124e27a943f2e0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=4c74e480cdeb49b1c14f4d872d839d32&qypid=7936953909_04000000001000000000_96&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=6815186121e5b23599891a6e87ecb5bf&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893"}}
         * img : http://u8.qiyipic.com/image/20170519/ca/98/uv_2040033745_m_601.jpg
         */

        private String thumbnail;
        private String swfurl;
        private UrllistBean urllist;
        private String img;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getSwfurl() {
            return swfurl;
        }

        public void setSwfurl(String swfurl) {
            this.swfurl = swfurl;
        }

        public UrllistBean getUrllist() {
            return urllist;
        }

        public void setUrllist(UrllistBean urllist) {
            this.urllist = urllist;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public static class UrllistBean {
            /**
             * mp4 : {"2":"http://data.video.qiyi.com/videos/v1/20170519/64/a6/7e9182cb409f51c694bc2a0e5f5a17ba.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501041&qd_ip=751952af&qd_p=751952af&qd_sc=5beba51eced2df941602111fb387da0c&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1","1":"http://data.video.qiyi.com/videos/v1/20170519/64/a6/bc7ae488e7aa8327ddd06d0d52090efa.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501042&qd_ip=751952af&qd_p=751952af&qd_sc=a3807d14a211687cf5e9cfa5b13e0e39&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1"}
             * m3u8 : {"2":"http://cache.m.iqiyi.com/mus/7936953909/08d2b502c23dba8082fec1203e6d9317/afbe8fd3d73448c9//20170519/64/a6/f75dfb9d5f52bf7af50e87b4780cebb0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=0b0067360c163f965039606b95d66fff&qypid=7936953909_04000000001000000000_2&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=c2d5101647c56c4a2afd0579124d429e&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893","1":"http://cache.m.iqiyi.com/mus/7936953909/34041a82c50a5272a61df5c7801c714a/afbe8fd3d73448c9//20170519/d0/36/e03f31a4ef80f71354ea0499ec9bdc7d.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=582de94c39458a5a5a8b34d9b7628c49&qypid=7936953909_04000000001000000000_1&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=a19e29797bedf2ed203f3d512a3e501a&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893","96":"http://cache.m.iqiyi.com/mus/7936953909/7049f905e86acb4ed725fb170fec1689/afbe8fd3d73448c9//20170519/2e/32/4352dc42ef4417408d124e27a943f2e0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=4c74e480cdeb49b1c14f4d872d839d32&qypid=7936953909_04000000001000000000_96&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=6815186121e5b23599891a6e87ecb5bf&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893"}
             */

            private Mp4Bean mp4;
            private M3u8Bean m3u8;

            public Mp4Bean getMp4() {
                return mp4;
            }

            public void setMp4(Mp4Bean mp4) {
                this.mp4 = mp4;
            }

            public M3u8Bean getM3u8() {
                return m3u8;
            }

            public void setM3u8(M3u8Bean m3u8) {
                this.m3u8 = m3u8;
            }

            public static class Mp4Bean {
                /**
                 * 2 : http://data.video.qiyi.com/videos/v1/20170519/64/a6/7e9182cb409f51c694bc2a0e5f5a17ba.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501041&qd_ip=751952af&qd_p=751952af&qd_sc=5beba51eced2df941602111fb387da0c&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1
                 * 1 : http://data.video.qiyi.com/videos/v1/20170519/64/a6/bc7ae488e7aa8327ddd06d0d52090efa.mp4?v=1067381974&qd_src=vcl&qd_tm=1516260501042&qd_ip=751952af&qd_p=751952af&qd_sc=a3807d14a211687cf5e9cfa5b13e0e39&qypid=7936953909_-101893&qd_uid=0&qd_vip=0&qdv=1
                 */

                @SerializedName("2")
                private String _$2;
                @SerializedName("1")
                private String _$1;

                public String get_$2() {
                    return _$2;
                }

                public void set_$2(String _$2) {
                    this._$2 = _$2;
                }

                public String get_$1() {
                    return _$1;
                }

                public void set_$1(String _$1) {
                    this._$1 = _$1;
                }
            }

            public static class M3u8Bean {
                /**
                 * 2 : http://cache.m.iqiyi.com/mus/7936953909/08d2b502c23dba8082fec1203e6d9317/afbe8fd3d73448c9//20170519/64/a6/f75dfb9d5f52bf7af50e87b4780cebb0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=0b0067360c163f965039606b95d66fff&qypid=7936953909_04000000001000000000_2&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=c2d5101647c56c4a2afd0579124d429e&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893
                 * 1 : http://cache.m.iqiyi.com/mus/7936953909/34041a82c50a5272a61df5c7801c714a/afbe8fd3d73448c9//20170519/d0/36/e03f31a4ef80f71354ea0499ec9bdc7d.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=582de94c39458a5a5a8b34d9b7628c49&qypid=7936953909_04000000001000000000_1&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=a19e29797bedf2ed203f3d512a3e501a&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893
                 * 96 : http://cache.m.iqiyi.com/mus/7936953909/7049f905e86acb4ed725fb170fec1689/afbe8fd3d73448c9//20170519/2e/32/4352dc42ef4417408d124e27a943f2e0.m3u8?qd_originate=tmts_py&tvid=7936953909&bossStatus=0&qd_vip=0&px=&qd_src=null&prv=&previewType=&previewTime=&from=&qd_time=1516260501034&qd_p=7f000001&qd_asc=4c74e480cdeb49b1c14f4d872d839d32&qypid=7936953909_04000000001000000000_96&qd_k=d51ae43b7a9d3c22bbf7275477fc73e9&isdol=0&code=2&vf=6815186121e5b23599891a6e87ecb5bf&np_tag=nginx_part_tag&v=532127184&qypid=7936953909_-101893
                 */

                @SerializedName("2")
                private String _$2;
                @SerializedName("1")
                private String _$1;
                @SerializedName("96")
                private String _$96;

                public String get_$2() {
                    return _$2;
                }

                public void set_$2(String _$2) {
                    this._$2 = _$2;
                }

                public String get_$1() {
                    return _$1;
                }

                public void set_$1(String _$1) {
                    this._$1 = _$1;
                }

                public String get_$96() {
                    return _$96;
                }

                public void set_$96(String _$96) {
                    this._$96 = _$96;
                }
            }
        }
    }
}
