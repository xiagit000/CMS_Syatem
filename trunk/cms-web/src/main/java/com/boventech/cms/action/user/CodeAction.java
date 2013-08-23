package com.boventech.cms.action.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;
import com.boventech.util.action.ActionUtil;

/**
 * Servlet implementation class CodeServlet
 */
public class CodeAction extends AbstractAction {

    private static final int MAX_HIGHLIGHT = 255;
	private static final int HIGHLIGHT_INCRE = 70;
	private static final int LINE_BC = 80;
	private static final int LINE_FC = 20;
	private static final int PIC_BC = 255;
	private static final int PIC_FC = 220;
	private static final int FONT_SIZE = 20;
	private static final int IMG_HEIGHT = 20;
	private static final int IMG_WIDTH = 55;
	private static final int MAX_RANDOM = 9999;
	private static final int MIN_RANDOM = 1000;
	private static final int RANDOM_SIZE = 10000;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int THIRTEEN = 13;
	private static final int EIGHTEEN = 18;
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeAction() {
        super();
    }

    private Random random = new Random();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();

        String srand = getRand();
        session.setAttribute("random", srand);
        // request.getSession().setAttribute("random", srand);
        BufferedImage image = getImage(srand);
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    /**
     * getRand <br>
     * <b>说明 </b> 生成验证码字符串
     * 
     * @return
     */
    private String getRand() {
        int rnd = random.nextInt(RANDOM_SIZE);
        if (rnd < MIN_RANDOM)
            rnd = MAX_RANDOM - rnd;
        return String.valueOf(rnd);
    }

    /**
     * getImage <br>
     * <b>说明 </b> 根据验证码字符串生成图片
     * 
     * @param srand
     *            要生成的验证
     * @return
     */
    private BufferedImage getImage(String srand) {
        int topmargin = 0;
        int width = IMG_WIDTH, height = IMG_HEIGHT + topmargin;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // 图片的背景比较明
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(getRandColor(PIC_FC, PIC_BC, false));
        g.fillRect(0, topmargin, width, height);
        g.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));

        // 绘制干扰线
        for (int i = 0; i < THREE; i++) {
            g.setColor(getRandColor(LINE_FC, LINE_BC, true));
            int x = random.nextInt(width / FOUR);
            int y = random.nextInt(height - topmargin) + topmargin;
            int xl = random.nextInt(width / FOUR) + THREE * width / FOUR;
            int yl = random.nextInt(height - topmargin) + topmargin;
            g.drawLine(x, y, xl, yl);
        }
        for (int i = 0; i < FOUR; i++) {
            g.setColor(getRandColor(LINE_FC, LINE_BC, true));
            g.drawString(srand.substring(i, i + 1), THIRTEEN * i + THREE, EIGHTEEN + topmargin);
        }
        g.dispose();
        return image;
    }

    /**
     * getRandColor <br>
     * <b>说明</b> 给定范围获得随机颜色
     * 
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc, boolean highlight) {
        int hilight = -1;
        if (highlight)
            hilight = random.nextInt(THREE);
        int[] c = new int[THREE];
        for (int i = 0; i < THREE; i++) {
            c[i] = random.nextInt(bc - fc) + fc;
            if (hilight == i) {
                c[i] += HIGHLIGHT_INCRE;
                if (c[i] > MAX_HIGHLIGHT)
                    c[i] = MAX_HIGHLIGHT;
            }
        }
        return new Color(c[0], c[1], c[2]);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public HttpHeaders create() {
        HttpServletRequest request = ActionUtil.getHttpRequest();
        HttpServletResponse response = ActionUtil.getHttpResponse();
        try {
            doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String destroy() {
        return null;
    }

    @Override
    public String edit() {
        return null;
    }

    @Override
    public HttpHeaders editNew() {
        return null;
    }

    @Override
    public HttpHeaders index() {
        HttpServletRequest request = ActionUtil.getHttpRequest();
        HttpServletResponse response = ActionUtil.getHttpResponse();
        try {
            doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HttpHeaders show() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

}
